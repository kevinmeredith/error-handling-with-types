// throw exception within a try/catch
def f: Int = {
	try {
		throw new Exception("!")
	}
	catch {
		case _ => 43
	}
}

// throw outside of a try/catch
def g: Int = {
	throw new Exception("!")
	try {
		42 + 42
	}
	catch {
		case _ => 666
	}
}