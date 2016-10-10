package net.service.either

import net.http.exception.HttpOrderService.OrderRequest

object OrderService {

	sealed trait UpdateOrderError
	case object NoOrderFound               extends UpdateOrderError
	case class DbUpdateError(t: Throwable) extends UpdateOrderError

	// An Order that exists in the system, i.e. DB
	case class Order(id: Long, quantity: Int)

	def update(req: OrderRequest): Either[UpdateOrderError, Unit] = 
		get(req) match {
			case Right(order) => updateHelper(o)
			case Left(e)      => Left(e)
		}

	private def updateHelper(o: Order): Either[UpdateOrderError, Unit] = 
		Left(DbUpdateError)

	private def get(o: OrderRequest): Either[UpdateOrderError, Order] = 
		???
}