< ? x m l   v e r s i o n = " 1 . 0 "   e n c o d i n g = " u t f - 8 " ? >  
 < x s l : s t y l e s h e e t   v e r s i o n = " 2 . 0 "  
       x m l n s : x s l = " h t t p : / / w w w . w 3 . o r g / 1 9 9 9 / X S L / T r a n s f o r m "  
       x m l n s : x s = " h t t p : / / w w w . w 3 . o r g / 2 0 0 1 / X M L S c h e m a "  
       x m l n s : f n = " h t t p : / / w w w . w 3 . o r g / 2 0 0 5 / x p a t h - f u n c t i o n s "  
       x m l n s : x a l a n = " h t t p : / / x m l . a p a c h e . o r g / x a l a n " >  
     < x s l : o u t p u t   m e t h o d = " x m l "   v e r s i o n = " 1 . 0 "   e n c o d i n g = " g b 2 3 1 2 "   i n d e n t = " n o " / >  
     < x s l : s t r i p - s p a c e   e l e m e n t s = " * " / >  
     < x s l : t e m p l a t e   m a t c h = " / " >  
         < x s l : v a r i a b l e   n a m e = " o w n e r N a m e "   s e l e c t = " / / o w n e r N a m e [ t e x t ( ) ] " / >  
         < x s l : v a r i a b l e   n a m e = " p r o v i n c e C o d e "   s e l e c t = " / / p r o v i n c e C o d e [ t e x t ( ) ] " / >  
         < x s l : v a r i a b l e   n a m e = " p a g e "   s e l e c t = " / / p a g e [ t e x t ( ) ] " / >  
  
         < s e l e c t P a r a m R o o t >  
             < c o l u m n >  
                 < c o l u m n > p r o v i n c e C o d e < / c o l u m n >  
                 < c o l u m n > o w n e r I d < / c o l u m n >  
                 < c o l u m n > o w n e r N a m e < / c o l u m n >  
                 < c o l u m n > o w n e r A d d r e s s < / c o l u m n >  
                 < c o l u m n > o r g a n i z a t i o n C o d e < / c o l u m n >  
                 < c o l u m n > p a r e n t O w n e r n a m e < / c o l u m n >  
                 < c o l u m n > n a t i v e A r e a C o d e < / c o l u m n >  
                 < c o l u m n > p r i n c i p a l N a m e < / c o l u m n >  
                 < c o l u m n > p r i n c i p a l T e l e p h o n e < / c o l u m n >  
                 < c o l u m n > p r i n c i p a l C e l l p h o n e < / c o l u m n >  
                 < c o l u m n > o p e r a t i n g S t a t u s < / c o l u m n >  
                 < c o l u m n > o p e r a t i n g C o d e < / c o l u m n >  
                 < c o l u m n > e c o n o m y T y p e < / c o l u m n >  
                 < c o l u m n > c r e a t e D a t e < / c o l u m n >  
                 < c o l u m n > m o d i f y D a t e < / c o l u m n >  
             < / c o l u m n >  
             < x s l : i f   t e s t = " $ o w n e r N a m e ! = ' ' " >  
                 < w h e r e s >  
                     < f u n c N a m e > a n d O w n e r N a m e I s N o t N u l l < / f u n c N a m e >  
                 < / w h e r e s >  
                 < w h e r e s >  
                     < f u n c N a m e > a n d O w n e r N a m e E q u a l T o < / f u n c N a m e >  
                     < p a r a m L i s t >  
                         < x s l : v a l u e - o f   s e l e c t = " $ o w n e r N a m e " / >  
                     < / p a r a m L i s t >  
                 < / w h e r e s >  
             < / x s l : i f >  
             < x s l : i f   t e s t = " $ p r o v i n c e C o d e ! = ' ' " >  
                 < w h e r e s >  
                     < f u n c N a m e > a n d P r o v i n c e C o d e E q u a l T o < / f u n c N a m e >  
                     < p a r a m L i s t >  
                         < x s l : v a l u e - o f   s e l e c t = " $ p r o v i n c e C o d e " / >  
                     < / p a r a m L i s t >  
                 < / w h e r e s >  
             < / x s l : i f >  
             < m a p p e r n a m e > D w B a s e i n f o R o a d o w n e r < / m a p p e r n a m e >  
             < t a b l e n a m e > D W _ B A S E I N F O _ R O A D O W N E R < / t a b l e n a m e >  
             < p a g e I n f o >  
                 < x s l : i f   t e s t = " $ p a g e ! = ' ' " >  
                     < p a g e >  
                         < x s l : v a l u e - o f   s e l e c t = " $ p a g e " / >  
                     < / p a g e >  
                 < / x s l : i f >  
             < / p a g e I n f o >  
         < / s e l e c t P a r a m R o o t >  
     < / x s l : t e m p l a t e >  
 < / x s l : s t y l e s h e e t > 