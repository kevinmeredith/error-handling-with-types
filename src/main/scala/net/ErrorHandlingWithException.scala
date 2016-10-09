object HttpOrderService {

	import scala.util.{Try, Success, Failure}
	import OrderSerivce.{NoOrderFoundErrorMessage, UpdateDbErrorMessage}

	sealed trait HttpResponse 
	case object Ok                  extends HttpResponse
	case object BadRequest          extends HttpResponse
	case object InternalServerError extends HttpResponse

	case class OrderRequest(id: Long, newQuantity: Int)

	// PUT /order/{id} 
	// Update the quantity of an Order by ID
	def createItem(o: OrderRequest): HttpResponse = 
		Try { OrderService.update(item) } match {
			case Success(_) => Ok
			case Failure(e) => createItemHelper(e)
		}

	private def createItemHelper(t: Throwable): HttpResponse = {
		if      (t.getMessage == NoOrderFoundErrorMessage) BadRequest
		else if (t.getMessage == UpdateDbErrorMessage)     InternalServerError
		else 	 										   InternalServerError
	}

}

object OrderSerivce {

	val NoOrderFoundErrorMessage = "Did not find order - cannot update."
	val UpdateDbErrorMessage     = "Failed to update order due to DB error."

	import HttpOrderService.OrderRequest

	// An Order that exists in the system, i.e. DB
	case class Order(id: Long, quantity: Int)

	// @throws RuntimeException on failure to update quantity of OrderRequest
	//         RuntimeException on failure to find OrderRequest
	def update(o: OrderRequest): Unit = {
		get(o) match {
			case Some(x) => updateHelper(o)
			case None    => throw new RuntimeException(NoOrderFoundErrorMessage) 
		}
	}

	private def updateHelper(o: Order): Unit = 
		throw new RuntimeException(UpdateDbErrorMessage)

	private def get(o: Order): Option[Order] = ???
}