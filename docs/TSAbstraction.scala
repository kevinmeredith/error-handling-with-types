case class Person(name: String, age: Int, id: Long)

trait UserRepository {
	def get(id: Long): Option[Person]
}

case object UserRepositoryImpl extends UserRepository {
	override def get(id: Long): Option[Person] = {
		// get connection to DB
		// perform look up
		// decode SQL DB Row into a Person
		???
	}
}

case object UserRepositoryTestImpl extends UserRepository {
	override def get(id: Long): Option[Person] = ???
}