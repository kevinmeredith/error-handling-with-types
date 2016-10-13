sealed trait Tree[+A]
case object Empty                                           extends Tree[Nothing]
case class Node[+A](left: Tree[A], leaf: A, right: Tree[A]) extends Tree[A]

sealed trait List[+A]
case object EmptyList 					 extends List[Nothing]
case class Cons[+A](x: A, tail: List[A]) extends List[A]