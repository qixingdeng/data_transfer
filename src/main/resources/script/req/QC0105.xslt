< ? x m l   v e r s i o n = " 1 . 0 "   e n c o d i n g = " u t f - 8 " ? >  
 < x s l : s t y l e s h e e t   v e r s i o n = " 2 . 0 "  
       x m l n s : x s l = " h t t p : / / w w w . w 3 . o r g / 1 9 9 9 / X S L / T r a n s f o r m "  
       x m l n s : x s = " h t t p : / / w w w . w 3 . o r g / 2 0 0 1 / X M L S c h e m a "  
       x m l n s : f n = " h t t p : / / w w w . w 3 . o r g / 2 0 0 5 / x p a t h - f u n c t i o n s "  
       x m l n s : x a l a n = " h t t p : / / x m l . a p a c h e . o r g / x a l a n " >  
     < x s l : o u t p u t   m e t h o d = " x m l "   v e r s i o n = " 1 . 0 "   e n c o d i n g = " g b 2 3 1 2 "   i n d e n t = " n o " / >  
     < x s l : s t r i p - s p a c e   e l e m e n t s = " * " / >  
     < x s l : t e m p l a t e   m a t c h = " / " >  
         < x s l : v a r i a b l e   n a m e = " v e h i c l e N o "   s e l e c t = " / / v e h i c l e N o [ t e x t ( ) ] " / >  
         < x s l : v a r i a b l e   n a m e = " p l a t e C o l o r "   s e l e c t = " / / p l a t e C o l o r [ t e x t ( ) ] " / >  
         < x s l : v a r i a b l e   n a m e = " p r o v i n c e C o d e "   s e l e c t = " / / p r o v i n c e C o d e [ t e x t ( ) ] " / >  
          
         < x s l : v a r i a b l e   n a m e = " l i m i t "   s e l e c t = " / / l i m i t [ t e x t ( ) ] " / >  
         < x s l : v a r i a b l e   n a m e = " p a g e "   s e l e c t = " / / p a g e [ t e x t ( ) ] " / >  
         < x s l : v a r i a b l e   n a m e = " t o t a l c o u n t "   s e l e c t = " / / t o t a l c o u n t [ t e x t ( ) ] " / >  
         < x s l : v a r i a b l e   n a m e = " t o t a l p a g e s "   s e l e c t = " / / t o t a l p a g e s [ t e x t ( ) ] " / >  
  
         < s e l e c t P a r a m R o o t >  
               < c o l u m n >  
                 < c o l u m n > p r o v i n c e C o d e < / c o l u m n >  
                 < c o l u m n > s i g n I d < / c o l u m n >  
                 < c o l u m n > o p e r L i n e I d < / c o l u m n >  
                 < c o l u m n > s i g n C o d e < / c o l u m n >  
                 < c o l u m n > p l a t e C o l o r < / c o l u m n >  
                 < c o l u m n > v e h i c l e N o < / c o l u m n >  
                 < c o l u m n > s i g n T y p e < / c o l u m n >  
                 < c o l u m n > v a l i d D a t e < / c o l u m n >  
                 < c o l u m n > e x p i r e D a t e < / c o l u m n >  
                 < c o l u m n > i s s u e D a t e < / c o l u m n >  
             < / c o l u m n >  
             < x s l : i f   t e s t = " $ v e h i c l e N o ! = ' ' " >  
                 < w h e r e s >  
                     < f u n c N a m e > a n d V e h i c l e N o E q u a l T o < / f u n c N a m e >  
                     < p a r a m L i s t >  
                         < x s l : v a l u e - o f   s e l e c t = " $ v e h i c l e N o " / >  
                     < / p a r a m L i s t >  
                 < / w h e r e s >  
             < / x s l : i f >  
             < x s l : i f   t e s t = " $ p l a t e C o l o r ! = ' ' " >  
                 < w h e r e s >  
                     < f u n c N a m e > a n d P l a t e C o l o r E q u a l T o < / f u n c N a m e >  
                     < p a r a m L i s t >  
                         < x s l : v a l u e - o f   s e l e c t = " $ p l a t e C o l o r " / >  
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
             < m a p p e r n a m e > D w B a s e i n f o L i n e D e n o t e r < / m a p p e r n a m e >  
             < t a b l e n a m e > < / t a b l e n a m e >  
             < p a g e I n f o >  
                 < x s l : i f   t e s t = " $ l i m i t ! = ' ' " >  
                     < l i m i t >  
                         < x s l : v a l u e - o f   s e l e c t = " $ l i m i t " / >  
                     < / l i m i t >  
                 < / x s l : i f >  
                 < x s l : i f   t e s t = " $ p a g e ! = ' ' " >  
                     < p a g e >  
                         < x s l : v a l u e - o f   s e l e c t = " $ p a g e " / >  
                     < / p a g e >  
                 < / x s l : i f >  
                 < x s l : i f   t e s t = " $ t o t a l c o u n t ! = ' ' " >  
                     < t o t a l c o u n t >  
                         < x s l : v a l u e - o f   s e l e c t = " $ t o t a l c o u n t " / >  
                     < / t o t a l c o u n t >  
                 < / x s l : i f >  
                 < x s l : i f   t e s t = " $ t o t a l p a g e s ! = ' ' " >  
                     < t o t a l p a g e s >  
                         < x s l : v a l u e - o f   s e l e c t = " $ t o t a l p a g e s " / >  
                     < / t o t a l p a g e s >  
                 < / x s l : i f >  
             < / p a g e I n f o >  
         < / s e l e c t P a r a m R o o t >  
     < / x s l : t e m p l a t e >  
 < / x s l : s t y l e s h e e t > 