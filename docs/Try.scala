sealed trait Try[+A]
case class Success[A](x: A)      extends Try[A]
case class Failure(t: Throwable) extends Try[Nothing]