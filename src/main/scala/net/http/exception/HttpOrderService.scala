package net.http.exception

import scala.util.{Try, Success, Failure}
import net.service.exception.OrderService
import OrderService.{NoOrderFoundErrorMessage, UpdateDbErrorMessage}

object HttpOrderService {

	sealed trait HttpResponse 
	case object Ok                  extends HttpResponse
	case object BadRequest          extends HttpResponse
	case object InternalServerError extends HttpResponse

	case class OrderRequest(id: Long, newQuantity: Int)

	// PUT /order/{id} 
	// Update the quantity of an Order by ID
	def createItem(o: OrderRequest): HttpResponse = 
		Try { OrderService.update(o) } match {
			case Success(_) => Ok
			case Failure(e) => createItemHelper(e)
		}

	private def createItemHelper(t: Throwable): HttpResponse = {
		if      (t.getMessage == NoOrderFoundErrorMessage) BadRequest
		else if (t.getMessage == UpdateDbErrorMessage)     InternalServerError
		else 	 										   InternalServerError
	}

}