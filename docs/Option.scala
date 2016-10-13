sealed trait Option[+A]
case class Some[+A](x: A) extends Option[A]
case object None          extends Option[Nothing]