< ? x m l   v e r s i o n = " 1 . 0 "   e n c o d i n g = " u t f - 8 " ? > 
 < x s l : s t y l e s h e e t   v e r s i o n = " 2 . 0 " 
         x m l n s : x s l = " h t t p : / / w w w . w 3 . o r g / 1 9 9 9 / X S L / T r a n s f o r m "   x m l n s : x s = " h t t p : / / w w w . w 3 . o r g / 2 0 0 1 / X M L S c h e m a " 
         x m l n s : f n = " h t t p : / / w w w . w 3 . o r g / 2 0 0 5 / x p a t h - f u n c t i o n s "   x m l n s : x a l a n = " h t t p : / / x m l . a p a c h e . o r g / x a l a n " > 
         < x s l : o u t p u t   m e t h o d = " x m l "   v e r s i o n = " 1 . 0 "   e n c o d i n g = " g b 2 3 1 2 " 
                 i n d e n t = " n o "   / > 
         < x s l : s t r i p - s p a c e   e l e m e n t s = " * "   / > 
         < x s l : t e m p l a t e   m a t c h = " / " > 
                 < x s l : v a r i a b l e   n a m e = " r o w s " 
                         s e l e c t = " / / s m P a r a m N o d e [ @ i d = ' S m P a r a m C a t a l o g ' ] / s m P a r a m N o d e [ n o t ( @ * ) ] "   / > 
                 < x s l : v a r i a b l e   n a m e = " p a g e i n f o "   s e l e c t = " / / s m P a r a m N o d e [ @ i d = ' S m P a r a m C a t a l o g ' ] / s m P a r a m N o d e [ @ i d = ' p a g e i n f o ' ] " / > 
                         < r e s p I n f o > 
                                   < r e s u l t c o n u n t > 
                                 < x s l : v a l u e - o f   s e l e c t = " c o u n t ( $ r o w s ) " / > 
                             < / r e s u l t c o n u n t > 
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
                                 < m e t a d a t a I n f o > 
                                         < m e t a d a t a C o d e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / / s m P a r a m N o d e [ @ k e y = ' m e t a d a t a C o d e ' ] / @ v a l u e "   / > 
                                         < / m e t a d a t a C o d e > 
                                         < m e t a d a t a N a m e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / / s m P a r a m N o d e [ @ k e y = ' m e t a d a t a N a m e ' ] / @ v a l u e "   / > 
                                         < / m e t a d a t a N a m e > 
                                         < m o d i f y D a t e > 
                                                 < x s l : v a l u e - o f   s e l e c t = " . / / s m P a r a m N o d e [ @ k e y = ' m o d i f y D a t e ' ] / @ v a l u e "   / > 
                                         < / m o d i f y D a t e > 
                                 < / m e t a d a t a I n f o > 
                         < / x s l : f o r - e a c h > 
                 < / r e s p I n f o > 
         < / x s l : t e m p l a t e > 
 < / x s l : s t y l e s h e e t > 