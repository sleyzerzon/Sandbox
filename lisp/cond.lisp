(defun absolute(x)
	(cond ((< x 0)(- x))
	 			((= x 0) 0)
				((> x 0) x)))
(print (absolute -3))
(print (absolute 3))
(print (absolute 0))

(defun absoluteIf(x)
 (if (< x 0)
		 (- x)
		 x))
(print (absoluteIf -3))
(print (absoluteIf 3))
(print (absoluteIf 0))
