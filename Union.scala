// Union Type
sealed trait UserConstructionError
case class InvalidAge(age: Int)      extends UserConstructionError
case class InvalidName(name: String) extends UserConstructionError
case object EmptyHobbies             extends UserConstructionError