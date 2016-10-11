object ExceptionBreakingRT {
	
	

	def f: Int = {
		try {
			throw new Exception("!")
		}
		catch {
			case _ => 43
		}
	}

	def g: Int = {
		throw new Exception("!")
		try {
			42 + 42
		}
		catch {
			case _ => 666
		}
	}
}