sealed trait Either[+A, +B]
case class Right[+A, +B](x: B) extends Either[A, B]
case class Left[+A, +B](x: A)  extends Either[A, B]

