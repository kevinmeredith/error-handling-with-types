sealed trait Try[+A]
case class Success[+A](x: A)         extends Try[A]
case class Failure[+A](t: Throwable) extends Try[A]