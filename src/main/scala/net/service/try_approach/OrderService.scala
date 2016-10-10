package net.service.try_approach

import net.http.try_approach.HttpOrderService.OrderRequest
import scala.util.Try

object OrderService {

	val NoOrderFoundErrorMessage = "Did not find order - cannot update."
	val UpdateDbErrorMessage     = "Failed to update order due to DB error."

	// An Order that exists in the system, i.e. DB
	case class Order(id: Long, quantity: Int)

	// @throws RuntimeException on failure to update quantity of OrderRequest
	//         RuntimeException on failure to find OrderRequest
	def update(o: OrderRequest): Try[Unit] = 
		get(o) match {
			case Some(oReq) => updateHelper(oReq)
			case None       => throw new RuntimeException(NoOrderFoundErrorMessage) 
		}

	private def updateHelper(o: Order): Try[Unit] = 
		Try { throw new RuntimeException(UpdateDbErrorMessage) } 

	private def get(o: OrderRequest): Option[Order] = ???
}