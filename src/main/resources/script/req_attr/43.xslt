< ? x m l   v e r s i o n = " 1 . 0 "   e n c o d i n g = " u t f - 8 " ? > 
 < x s l : s t y l e s h e e t   v e r s i o n = " 2 . 0 " 
       x m l n s : x s l = " h t t p : / / w w w . w 3 . o r g / 1 9 9 9 / X S L / T r a n s f o r m " 
       x m l n s : x s = " h t t p : / / w w w . w 3 . o r g / 2 0 0 1 / X M L S c h e m a " 
       x m l n s : f n = " h t t p : / / w w w . w 3 . o r g / 2 0 0 5 / x p a t h - f u n c t i o n s " 
       x m l n s : x a l a n = " h t t p : / / x m l . a p a c h e . o r g / x a l a n " > 
     < x s l : o u t p u t   m e t h o d = " x m l "   v e r s i o n = " 1 . 0 "   e n c o d i n g = " g b 2 3 1 2 "   i n d e n t = " n o " / > 
     < x s l : s t r i p - s p a c e   e l e m e n t s = " * " / > 
     < x s l : t e m p l a t e   m a t c h = " / " > 
         < x s l : p a r a m   n a m e = " t y p e C o d e "   s e l e c t = " t y p e C o d e " / > 
         < s e l e c t P a r a m R o o t > 
           < c o l u m n > 
                 < c o l u m n > t y p e P a r a m C o d e < / c o l u m n > 
                 < c o l u m n > t y p e P a r a m D e s c < / c o l u m n > 
                 < c o l u m n > p a r e n t P a r a m C o d e < / c o l u m n > 
                 < c o l u m n > p a r e n t P a r a m D e s c < / c o l u m n > 
                 < c o l u m n > s t a t e < / c o l u m n > 
                 < c o l u m n > m o d i f y D a t e < / c o l u m n > 
             < / c o l u m n > 
               < x s l : i f   t e s t = " $ t y p e C o d e ! = ' ' " > 
                 < w h e r e s > 
                     < f u n c N a m e > a n d T y p e C o d e E q u a l T o < / f u n c N a m e > 
                     < p a r a m L i s t > 
                         < x s l : v a l u e - o f   s e l e c t = " $ t y p e C o d e " / > 
                     < / p a r a m L i s t > 
                 < / w h e r e s > 
             < / x s l : i f > 
             < m a p p e r n a m e > S m P a r a m D e t a i l 2 < / m a p p e r n a m e > 
             < t a b l e n a m e > S m _ P a r a m _ D e t a i l < / t a b l e n a m e > 
         < / s e l e c t P a r a m R o o t > 
     < / x s l : t e m p l a t e > 
 < / x s l : s t y l e s h e e t > 