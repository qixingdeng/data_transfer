< ? x m l   v e r s i o n = " 1 . 0 "   e n c o d i n g = " u t f - 8 " ? > 
 < x s l : s t y l e s h e e t   v e r s i o n = " 2 . 0 " 
         x m l n s : x s l = " h t t p : / / w w w . w 3 . o r g / 1 9 9 9 / X S L / T r a n s f o r m "   x m l n s : x s = " h t t p : / / w w w . w 3 . o r g / 2 0 0 1 / X M L S c h e m a " 
         x m l n s : f n = " h t t p : / / w w w . w 3 . o r g / 2 0 0 5 / x p a t h - f u n c t i o n s "   x m l n s : x a l a n = " h t t p : / / x m l . a p a c h e . o r g / x a l a n " > 
         < x s l : o u t p u t   m e t h o d = " x m l "   v e r s i o n = " 1 . 0 "   e n c o d i n g = " g b 2 3 1 2 " 
                 i n d e n t = " n o "   / > 
         < x s l : s t r i p - s p a c e   e l e m e n t s = " * "   / > 
         < x s l : t e m p l a t e   m a t c h = " / " > 
                 < x s l : v a r i a b l e   n a m e = " r o w s "   s e l e c t = " / / s m P a r a m N o d e [ @ i d = ' D w I n f o B u s i n e s s L i c e n s e ' ] / s m P a r a m N o d e [ n o t ( @ * ) ] "   / > 
                 < x s l : v a r i a b l e   n a m e = " D w I n f o R o a d o w n e r C h e c k r o w s "   s e l e c t = " / / s m P a r a m N o d e [ @ i d = ' D w I n f o R o a d o w n e r C h e c k ' ] / s m P a r a m N o d e [ n o t ( @ * ) ] "   / > 
                 < x s l : v a r i a b l e   n a m e = " p a g e i n f o "   s e l e c t = " / / s m P a r a m N o d e [ @ i d = ' D w I n f o B u s i n e s s L i c e n s e ' ] / s m P a r a m N o d e [ @ i d = ' p a g e i n f o ' ] " / > 
                         < r e s p I n f o > 
                                   < r e s u l t C o u n t > 
                                 < x s l : v a l u e - o f   s e l e c t = " c o u n t ( $ r o w s ) " / > 
                             < / r e s u l t C o u n t > 
                             < x s l : i f   t e s t = " c o u n t ( $ p a g e i n f o )   ! = 0 " > 
                                 < p a g e I n f o > 
                                     < l i m i t > 
                                         < x s l : v a l u e - o f   s e l e c t = " $ p a g e i n f o / s m P a r a m N o d e [ @ k e y = ' l i m i t ' ] / @ v a l u e " / > 
                                     < / l i m i t > 
                                     < p a g e > 
                                         < x s l : v a l u e - o f   s e l e c t = " $ p a g e i n f o / s m P a r a m N o d e [ @ k e y = ' p a g e ' ] / @ v a l u e " / > 
                                     < / p a g e > 
                                     < t o t a l c o u n t > 
                                         < x s l : v a l u e - o f   s e l e c t = " $ p a g e i n f o / s m P a r a m N o d e [ @ k e y = ' t o t a l c o u n t ' ] / @ v a l u e " / > 
                                     < / t o t a l c o u n t > 
                                     < t o t a l p a g e s > 
                                         < x s l : v a l u e - o f   s e l e c t = " $ p a g e i n f o / s m P a r a m N o d e [ @ k e y = ' t o t a l p a g e s ' ] / @ v a l u e " / > 
                                     < / t o t a l p a g e s > 
                                 < / p a g e I n f o > 
                             < / x s l : i f > 
                         < x s l : f o r - e a c h   s e l e c t = " $ r o w s " > 
                                 < o w n e r I n f o > 
                                         < p r o v i n c e C o d e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' p r o v i n c e C o d e ' ] / @ v a l u e "   / > 
                                         < / p r o v i n c e C o d e > 
                                         < o w n e r I d > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' o w n e r I d ' ] / @ v a l u e "   / > 
                                         < / o w n e r I d > 
                                         < o w n e r N a m e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' o w n e r N a m e ' ] / @ v a l u e "   / > 
                                         < / o w n e r N a m e > 
                                         < o w n e r A d d r e s s > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' o w n e r A d d r e s s ' ] / @ v a l u e "   / > 
                                         < / o w n e r A d d r e s s > 
                                         < o r g a n i z a t i o n C o d e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' o r g a n i z a t i o n C o d e ' ] / @ v a l u e "   / > 
                                         < / o r g a n i z a t i o n C o d e > 
                                         < p a r e n t O w n e r n a m e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' p a r e n t O w n e r n a m e ' ] / @ v a l u e "   / > 
                                         < / p a r e n t O w n e r n a m e > 
                                         < n a t i v e A r e a C o d e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' n a t i v e A r e a C o d e ' ] / @ v a l u e "   / > 
                                         < / n a t i v e A r e a C o d e > 
                                         < p r i n c i p a l N a m e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' p r i n c i p a l N a m e ' ] / @ v a l u e "   / > 
                                         < / p r i n c i p a l N a m e > 
                                         < p r i n c i p a l T e l e p h o n e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' p r i n c i p a l T e l e p h o n e ' ] / @ v a l u e "   / > 
                                         < / p r i n c i p a l T e l e p h o n e > 
                                         < p r i n c i p a l C e l l p h o n e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' p r i n c i p a l C e l l p h o n e ' ] / @ v a l u e "   / > 
                                         < / p r i n c i p a l C e l l p h o n e > 
                                         < o p e r a t i n g S t a t u s > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' o p e r a t i n g S t a t u s ' ] / @ v a l u e "   / > 
                                         < / o p e r a t i n g S t a t u s > 
                                         < o p e r a t i n g C o d e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' o p e r a t i n g C o d e ' ] / @ v a l u e "   / > 
                                         < / o p e r a t i n g C o d e > 
                                         < e c o n o m y T y p e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' e c o n o m y T y p e ' ] / @ v a l u e "   / > 
                                         < / e c o n o m y T y p e > 
                                         < c r e a t e D a t e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " t r a n s l a t e ( s u b s t r i n g - b e f o r e ( . / s m P a r a m N o d e [ @ k e y = ' c r e a t e D a t e ' ] / @ v a l u e , '   ' ) , ' - ' , ' ' ) " / > 
                                         < / c r e a t e D a t e > 
                                         < m o d i f y D a t e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " t r a n s l a t e ( s u b s t r i n g - b e f o r e ( . / s m P a r a m N o d e [ @ k e y = ' m o d i f y D a t e ' ] / @ v a l u e , '   ' ) , ' - ' , ' ' ) " / > 
                                         < / m o d i f y D a t e > 
                                         
                                         < c e r t i f i c a t e I n f o > 
                                                 < b u s i n e s s S c o p e C o d e > 
                                                         < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' b u s i n e s s S c o p e C o d e ' ] / @ v a l u e "   / > 
                                                 < / b u s i n e s s S c o p e C o d e > 
                                                 < b u s i n e s s S c o p e D e s c > 
                                                         < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' b u s i n e s s S c o p e D e s c ' ] / @ v a l u e "   / > 
                                                 < / b u s i n e s s S c o p e D e s c > 
                                                 < l i c e n s e W o r d > 
                                                         < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' l i c e n s e W o r d ' ] / @ v a l u e "   / > 
                                                 < / l i c e n s e W o r d > 
                                                 < l i c e n s e C o d e > 
                                                         < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' l i c e n s e C o d e ' ] / @ v a l u e "   / > 
                                                 < / l i c e n s e C o d e > 
                                                 < v a l i d B e g i n D a t e > 
                                                         < x s l : v a l u e - o f   s e l e c t = " t r a n s l a t e ( s u b s t r i n g - b e f o r e ( . / s m P a r a m N o d e [ @ k e y = ' v a l i d B e g i n D a t e ' ] / @ v a l u e , '   ' ) , ' - ' , ' ' ) " / > 
                                                 < / v a l i d B e g i n D a t e > 
                                                 < e x p i r e D a t e > 
                                                         < x s l : v a l u e - o f   s e l e c t = " t r a n s l a t e ( s u b s t r i n g - b e f o r e ( . / s m P a r a m N o d e [ @ k e y = ' e x p i r e D a t e ' ] / @ v a l u e , '   ' ) , ' - ' , ' ' ) " / > 
                                                 < / e x p i r e D a t e > 
                                                 < l i c e n s e I s s u e O r g a n > 
                                                         < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' l i c e n s e I s s u e O r g a n ' ] / @ v a l u e "   / > 
                                                 < / l i c e n s e I s s u e O r g a n > 
                                                 < l i c e n s e I s s u e D a t e > 
                                                         < x s l : v a l u e - o f   s e l e c t = " t r a n s l a t e ( s u b s t r i n g - b e f o r e ( . / s m P a r a m N o d e [ @ k e y = ' l i c e n s e I s s u e D a t e ' ] / @ v a l u e , '   ' ) , ' - ' , ' ' ) " / > 
                                                 < / l i c e n s e I s s u e D a t e > 
                                                 < a d d r e s s > 
                                                         < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' a d d r e s s ' ] / @ v a l u e "   / > 
                                                 < / a d d r e s s > 
                                                 < o p e r a t i n g S t a t u s > 
                                                         < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' o p e r a t i n g S t a t u s ' ] / @ v a l u e "   / > 
                                                 < / o p e r a t i n g S t a t u s > 
                                                 < c e r t i f i c a t e S t a t e > 
                                                         < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' c e r t i f i c a t e S t a t e ' ] / @ v a l u e "   / > 
                                                 < / c e r t i f i c a t e S t a t e > 
                                                 < c r e a t e D a t e > 
                                                         < x s l : v a l u e - o f   s e l e c t = " t r a n s l a t e ( s u b s t r i n g - b e f o r e ( . / s m P a r a m N o d e [ @ k e y = ' c r e a t e D a t e ' ] / @ v a l u e , '   ' ) , ' - ' , ' ' ) " / > 
                                                 < / c r e a t e D a t e > 
                                                 < m o d i f y D a t e > 
                                                         < x s l : v a l u e - o f   s e l e c t = " t r a n s l a t e ( s u b s t r i n g - b e f o r e ( . / s m P a r a m N o d e [ @ k e y = ' m o d i f y D a t e ' ] / @ v a l u e , '   ' ) , ' - ' , ' ' ) " / > 
                                                 < / m o d i f y D a t e > 
                                         < / c e r t i f i c a t e I n f o > 
                                         
                                         < x s l : i f   t e s t = " c o u n t ( $ D w I n f o R o a d o w n e r C h e c k r o w s )   ! = 0 " > 
                                         < x s l : f o r - e a c h   s e l e c t = " $ D w I n f o R o a d o w n e r C h e c k r o w s " > 
                                                 < q u a l i t y E x a m I n f o > 
                                                         < c h e c k D a t e > 
                                                                 < x s l : v a l u e - o f   s e l e c t = " t r a n s l a t e ( s u b s t r i n g - b e f o r e ( . / s m P a r a m N o d e [ @ k e y = ' c h e c k D a t e ' ] / @ v a l u e , '   ' ) , ' - ' , ' ' ) " / > 
                                                         < / c h e c k D a t e > 
                                                         < c h e c k Y e a r > 
                                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' c h e c k Y e a r ' ] / @ v a l u e "   / > 
                                                         < / c h e c k Y e a r > 
                                                         < c h e c k O r a N a m e > 
                                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' c h e c k O r a N a m e ' ] / @ v a l u e "   / > 
                                                         < / c h e c k O r a N a m e > 
                                                         < c h e c k M a r k > 
                                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' c h e c k M a r k ' ] / @ v a l u e "   / > 
                                                         < / c h e c k M a r k > 
                                                         < c h e c k R e s u l t > 
                                                                 < x s l : v a l u e - o f   s e l e c t = " . / s m P a r a m N o d e [ @ k e y = ' c h e c k R e s u l t ' ] / @ v a l u e "   / > 
                                                         < / c h e c k R e s u l t > 
                                                         
                                                 < / q u a l i t y E x a m I n f o > 
                                         < / x s l : f o r - e a c h > 
                                         < / x s l : i f > 
                                         
                                 < / o w n e r I n f o > 
                         < / x s l : f o r - e a c h > 
                 < / r e s p I n f o > 
         < / x s l : t e m p l a t e > 
 < / x s l : s t y l e s h e e t > 