< ? x m l   v e r s i o n = " 1 . 0 "   e n c o d i n g = " u t f - 8 " ? > 
 < x s l : s t y l e s h e e t   v e r s i o n = " 2 . 0 " 
       x m l n s : x s l = " h t t p : / / w w w . w 3 . o r g / 1 9 9 9 / X S L / T r a n s f o r m " 
       x m l n s : x s = " h t t p : / / w w w . w 3 . o r g / 2 0 0 1 / X M L S c h e m a " 
       x m l n s : f n = " h t t p : / / w w w . w 3 . o r g / 2 0 0 5 / x p a t h - f u n c t i o n s " 
       x m l n s : x a l a n = " h t t p : / / x m l . a p a c h e . o r g / x a l a n " > 
     < x s l : o u t p u t   m e t h o d = " x m l "   v e r s i o n = " 1 . 0 "   e n c o d i n g = " g b 2 3 1 2 "   i n d e n t = " n o " / > 
     < x s l : s t r i p - s p a c e   e l e m e n t s = " * " / > 
     < x s l : t e m p l a t e   m a t c h = " / " > 
         < x s l : p a r a m   n a m e = " s t a f f I d "   s e l e c t = " s t a f f I d " / > 
         < s e l e c t P a r a m R o o t > 
           < c o l u m n > 
                 < c o l u m n > w o r k T y p e C o d e < / c o l u m n > 
                 < c o l u m n > c e r t i f i c a t e C o d e < / c o l u m n > 
                 < c o l u m n > c e r t i f i c a t e F i r s t I s s u e D a t e < / c o l u m n > 
                 < c o l u m n > c e r t i f i c a t e I s s u e D a t e < / c o l u m n > 
                 < c o l u m n > c e r t i f i c a t e E x p i r e D a t e < / c o l u m n > 
                 < c o l u m n > i s s u e O r g a n < / c o l u m n >  
                 < c o l u m n > i s s u e O r g a n L o c C o d e < / c o l u m n > 
                 < c o l u m n > c e r t i f i c a t e S t a t e < / c o l u m n > 
                 < c o l u m n > c e r t i f i c a t e T y p e < / c o l u m n > 
                 < c o l u m n > i c C a r d C e r t i f i c a t e C o d e i c < / c o l u m n >  
                 < c o l u m n > c r e a t e D a t e < / c o l u m n >  
                 < c o l u m n > m o d i f y D a t e < / c o l u m n > 
             < / c o l u m n > 
             < x s l : i f   t e s t = " $ s t a f f I d ! = ' ' " > 
                 < w h e r e s > 
                     < f u n c N a m e > a n d S t a f f I d E q u a l T o < / f u n c N a m e > 
                     < p a r a m L i s t > 
                         < x s l : v a l u e - o f   s e l e c t = " $ s t a f f I d " / > 
                     < / p a r a m L i s t > 
                 < / w h e r e s > 
             < / x s l : i f > 
             < m a p p e r n a m e > D w B a s e i n f o S t a f f C e r t < / m a p p e r n a m e > 
             < t a b l e n a m e > d w _ b a s e i n f o _ s t a f f _ c e r t < / t a b l e n a m e > 
         < / s e l e c t P a r a m R o o t > 
     < / x s l : t e m p l a t e > 
 < / x s l : s t y l e s h e e t > 