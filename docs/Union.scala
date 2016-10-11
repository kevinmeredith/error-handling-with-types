object Union {
	sealed trait UserError
	case class InvalidAge(age: Int)      extends UserError
	case class InvalidName(name: String) extends UserError
	case object EmptyHobbies             extends UserError
}