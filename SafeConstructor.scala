class SSN private (val value: Int)

object SSN {
	def apply(number: Int): Option[SSN] = 
		if(number.toString.length == 9) Some( new SSN(number) ) else None
}

class NonEmptyString private (value: String)

object NonEmptyString {
	def apply(x: String): Option[NonEmptyString] = 
		if (x.nonEmpty) Some( new NonEmptyString(x) ) else None
}

case class Person(name: NonEmptyString, birthday: java.time.LocalDate, ssn: SSN)