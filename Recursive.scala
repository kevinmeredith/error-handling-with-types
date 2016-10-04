// Recursive type
sealed trait Tree[+A]
case object Empty                                          extends Tree[Nothing]
case class Node[A](left: Tree[A], leaf: A, right: Tree[A]) extends Tree[A]