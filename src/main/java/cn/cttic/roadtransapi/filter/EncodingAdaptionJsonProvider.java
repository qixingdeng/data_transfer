package cn.cttic.roadtransapi.filter;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jackson.type.JavaType;


@Provider
@Consumes({MediaType.APPLICATION_JSON, "application/json", "text/json"})
@Produces({MediaType.APPLICATION_JSON, "application/json", "text/json"})
public class EncodingAdaptionJsonProvider  extends JacksonJsonProvider {
	public EncodingAdaptionJsonProvider() {
        super();
        ObjectMapper om = _mapperConfig.getConfiguredMapper();
        if (om == null) {
            om = _mapperConfig.getDefaultMapper();
            _mapperConfig.setMapper(om);
        }
        SerializationConfig sconfig = om.getSerializationConfig();
        if (sconfig != null) {
            sconfig.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        }
    }

    public long getSize(Object value, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return super.getSize(value, type, genericType, annotations, mediaType);
    }

    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return super.isWriteable(type, genericType, annotations, mediaType);
    }

    public void writeTo(Object value, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
            throws IOException {
        ObjectMapper mapper = locateMapper(type, mediaType);
        Map<String, String> params = mediaType.getParameters();
        String encoding = ThreadLocalVariables.get(ThreadLocalVariables.VAR_NAME_CHARSET_NAME);
        GET_CHARSET:
        if (params != null) {
            String charsetKey = "charset";
            if (params.containsKey(charsetKey)) {
                encoding = params.get(charsetKey);
                break GET_CHARSET;
            }
        }
        //根据请求的MIME-TYPE自动适应响应编码
        JsonGenerator jg = null;
        JsonEncoding enc = findEncoding(mediaType, httpHeaders);
        Writer writer = null;

        try {
            Charset charset = Charset.forName(encoding);
            writer = new OutputStreamWriter(entityStream, charset);
            jg = mapper.getJsonFactory().createJsonGenerator(writer);
        } catch (UnsupportedCharsetException ex) {
            //不支持
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "不支持的字符编码：" + ex.getCharsetName(), ex);
            jg = mapper.getJsonFactory().createJsonGenerator(entityStream, enc);
        } catch (IllegalCharsetNameException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "非法的字符编码名称：" + ex.getCharsetName(), ex);
            jg = mapper.getJsonFactory().createJsonGenerator(entityStream, enc);
        }
        jg.disable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);
        if (mapper.getSerializationConfig().isEnabled(SerializationConfig.Feature.INDENT_OUTPUT)) {
            jg.useDefaultPrettyPrinter();
        }
        JavaType rootType = null;

        if (genericType != null && value != null) {
            if (genericType.getClass() != Class.class) {
                rootType = TypeFactory.type(genericType);
            }
        }
        if (_jsonpFunctionName != null) {
            mapper.writeValue(jg, new JSONPObject(_jsonpFunctionName, value, rootType));
        } else if (rootType != null) {
            mapper.typedWriter(rootType).writeValue(jg, value);
        } else {
            mapper.writeValue(jg, value);
        }
    }

    protected JsonEncoding findEncoding(MediaType mediaType, MultivaluedMap<String, Object> httpHeaders) {
        return super.findEncoding(mediaType, httpHeaders);
    }
}
