< ? x m l   v e r s i o n = " 1 . 0 "   e n c o d i n g = " u t f - 8 " ? >  
 < x s l : s t y l e s h e e t   v e r s i o n = " 2 . 0 "  
       x m l n s : x s l = " h t t p : / / w w w . w 3 . o r g / 1 9 9 9 / X S L / T r a n s f o r m "  
       x m l n s : x s = " h t t p : / / w w w . w 3 . o r g / 2 0 0 1 / X M L S c h e m a "  
       x m l n s : f n = " h t t p : / / w w w . w 3 . o r g / 2 0 0 5 / x p a t h - f u n c t i o n s "  
       x m l n s : x a l a n = " h t t p : / / x m l . a p a c h e . o r g / x a l a n " >  
     < x s l : o u t p u t   m e t h o d = " x m l "   v e r s i o n = " 1 . 0 "   e n c o d i n g = " g b 2 3 1 2 "   i n d e n t = " n o " / >  
     < x s l : s t r i p - s p a c e   e l e m e n t s = " * " / >  
     < x s l : t e m p l a t e   m a t c h = " / " >  
         < x s l : v a r i a b l e   n a m e = " j s o n _ o b j e c t "   s e l e c t = " / / j s o n _ o b j e c t [ t e x t ( ) ] " / >  
         < x s l : v a r i a b l e   n a m e = " b u s i _ o r d _ i d "   s e l e c t = " / / b u s i _ o r d _ i d [ t e x t ( ) ] " / >  
         < x s l : v a r i a b l e   n a m e = " p r o c _ i n s t a n c e _ i d "   s e l e c t = " / / p r o c _ i n s t a n c e _ i d [ t e x t ( ) ] " / >  
         < s o a p e n v : E n v e l o p e   x m l n s : s o a p e n v = " h t t p : / / s c h e m a s . x m l s o a p . o r g / s o a p / e n v e l o p e / "   x m l n s : w s = " h t t p : / / w s . a p p r o v a l . w t m s . c t t i c . c n / " >  
             < s o a p e n v : H e a d e r / >  
             < s o a p e n v : B o d y >  
                 < w s : C r e a t e O r d e r C o m m a n d >  
                     < ! - - O p t i o n a l : - - >  
                     < C r e a t e O r d e r R e q >  
                         < i s b a s e 6 4 > t r u e < / i s b a s e 6 4 >  
                         < ! - - O p t i o n a l : - - >  
                         < j s o n _ o b j e c t >  
                             < x s l : v a l u e - o f   s e l e c t = " $ j s o n _ o b j e c t " / >  
                         < / j s o n _ o b j e c t >  
                         < m a x J s o n O b j l e n > < / m a x J s o n O b j l e n >  
                         < ! - - O p t i o n a l : - - >  
                         < p r o c _ i n s t a n c e _ i d >  
                             < x s l : v a l u e - o f   s e l e c t = " $ p r o c _ i n s t a n c e _ i d " / >  
                         < / p r o c _ i n s t a n c e _ i d >  
                         < ! - - O p t i o n a l : - - >  
                         < b u s i _ o r d _ i d >  
                             < x s l : v a l u e - o f   s e l e c t = " $ b u s i _ o r d _ i d " / >  
                         < / b u s i _ o r d _ i d >  
                         < ! - - O p t i o n a l : - - >  
                         < f l a g > 1 0 0 1 < / f l a g >  
                     < / C r e a t e O r d e r R e q >  
                 < / w s : C r e a t e O r d e r C o m m a n d >  
             < / s o a p e n v : B o d y >  
         < / s o a p e n v : E n v e l o p e >  
     < / x s l : t e m p l a t e >  
 < / x s l : s t y l e s h e e t > 