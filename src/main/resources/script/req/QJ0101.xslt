< ? x m l   v e r s i o n = " 1 . 0 "   e n c o d i n g = " u t f - 8 " ? > 
 < x s l : s t y l e s h e e t   v e r s i o n = " 2 . 0 " 
       x m l n s : x s l = " h t t p : / / w w w . w 3 . o r g / 1 9 9 9 / X S L / T r a n s f o r m " 
       x m l n s : x s = " h t t p : / / w w w . w 3 . o r g / 2 0 0 1 / X M L S c h e m a " 
       x m l n s : f n = " h t t p : / / w w w . w 3 . o r g / 2 0 0 5 / x p a t h - f u n c t i o n s " 
       x m l n s : x a l a n = " h t t p : / / x m l . a p a c h e . o r g / x a l a n " > 
     < x s l : o u t p u t   m e t h o d = " x m l "   v e r s i o n = " 1 . 0 "   e n c o d i n g = " g b 2 3 1 2 "   i n d e n t = " n o " / > 
     < x s l : s t r i p - s p a c e   e l e m e n t s = " * " / > 
     < x s l : t e m p l a t e   m a t c h = " / " > 
         < x s l : v a r i a b l e   n a m e = " m a n a g e O r g a n N a m e "   s e l e c t = " / / m a n a g e O r g a n N a m e [ t e x t ( ) ] " / > 
         < x s l : v a r i a b l e   n a m e = " m a n a g e O r g a n C o d e "   s e l e c t = " / / m a n a g e O r g a n C o d e [ t e x t ( ) ] " / > 
         < x s l : v a r i a b l e   n a m e = " p r o v i n c e C o d e "   s e l e c t = " / / p r o v i n c e C o d e [ t e x t ( ) ] " / > 
         
         < x s l : v a r i a b l e   n a m e = " l i m i t "   s e l e c t = " / / l i m i t [ t e x t ( ) ] " / > 
         < x s l : v a r i a b l e   n a m e = " p a g e "   s e l e c t = " / / p a g e [ t e x t ( ) ] " / > 
         < x s l : v a r i a b l e   n a m e = " t o t a l c o u n t "   s e l e c t = " / / t o t a l c o u n t [ t e x t ( ) ] " / > 
         < x s l : v a r i a b l e   n a m e = " t o t a l p a g e s "   s e l e c t = " / / t o t a l p a g e s [ t e x t ( ) ] " / > 
 
         < s e l e c t P a r a m R o o t > 
               < c o l u m n > 
                 < c o l u m n > p r o v i n c e C o d e < / c o l u m n > 
                 < c o l u m n > o r g a n N a m e < / c o l u m n > 
                 < c o l u m n > o r g a n C o d e < / c o l u m n > 
                 < c o l u m n > a d d r e s s < / c o l u m n > 
                 < c o l u m n > z o n e < / c o l u m n > 
                 < c o l u m n > t e l e p h o n e < / c o l u m n > 
                 < c o l u m n > f a x < / c o l u m n > 
                 < c o l u m n > e m e r g e n c y C a l l < / c o l u m n > 
                 < c o l u m n > c o m p l a i n t s C a l l < / c o l u m n > 
                 < c o l u m n > p r i n c i p a l < / c o l u m n > 
             < / c o l u m n > 
             < x s l : i f   t e s t = " $ m a n a g e O r g a n N a m e ! = ' ' " > 
                 < w h e r e s > 
                     < f u n c N a m e > a n d O r g a n N a m e E q u a l T o < / f u n c N a m e > 
                     < p a r a m L i s t > 
                         < x s l : v a l u e - o f   s e l e c t = " $ m a n a g e O r g a n N a m e " / > 
                     < / p a r a m L i s t > 
                 < / w h e r e s > 
             < / x s l : i f > 
             < x s l : i f   t e s t = " $ m a n a g e O r g a n C o d e   ! =   ' ' " > 
                 < w h e r e s > 
                     < f u n c N a m e > a n d O r g a n C o d e E q u a l T o < / f u n c N a m e > 
                     < p a r a m L i s t > 
                         < x s l : v a l u e - o f   s e l e c t = " $ m a n a g e O r g a n C o d e " / > 
                     < / p a r a m L i s t > 
                 < / w h e r e s > 
             < / x s l : i f > 
             < x s l : i f   t e s t = " $ p r o v i n c e C o d e ! = ' ' " > 
                 < w h e r e s > 
                     < f u n c N a m e > a n d P r o v i n c e C o d e E q u a l T o < / f u n c N a m e > 
                     < p a r a m L i s t > 
                         < x s l : v a l u e - o f   s e l e c t = " $ p r o v i n c e C o d e " / > 
                     < / p a r a m L i s t > 
                 < / w h e r e s > 
             < / x s l : i f > 
             < m a p p e r n a m e > D w B a s e i n f o M a n a g e O r g a n < / m a p p e r n a m e > 
             < t a b l e n a m e > D w _ B a s e i n f o _ M a n a g e _ O r g a n < / t a b l e n a m e > 
             < p a g e I n f o > 
                 < x s l : i f   t e s t = " $ l i m i t ! = ' ' " > 
                     < l i m i t > 
                         < x s l : v a l u e - o f   s e l e c t = " $ l i m i t " / > 
                     < / l i m i t > 
                 < / x s l : i f > 
                 < x s l : i f   t e s t = " $ p a g e ! = ' ' " > 
                     < p a g e > 
                         < x s l : v a l u e - o f   s e l e c t = " $ p a g e " / > 
                     < / p a g e > 
                 < / x s l : i f > 
                 < x s l : i f   t e s t = " $ t o t a l c o u n t ! = ' ' " > 
                     < t o t a l c o u n t > 
                         < x s l : v a l u e - o f   s e l e c t = " $ t o t a l c o u n t " / > 
                     < / t o t a l c o u n t > 
                 < / x s l : i f > 
                 < x s l : i f   t e s t = " $ t o t a l p a g e s ! = ' ' " > 
                     < t o t a l p a g e s > 
                         < x s l : v a l u e - o f   s e l e c t = " $ t o t a l p a g e s " / > 
                     < / t o t a l p a g e s > 
                 < / x s l : i f > 
             < / p a g e I n f o > 
         < / s e l e c t P a r a m R o o t > 
     < / x s l : t e m p l a t e > 
 < / x s l : s t y l e s h e e t > 