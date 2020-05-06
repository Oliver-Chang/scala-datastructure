import java.util.logging.Logger

import com.oliverch.collection.{Queue, Stack}

object Main extends App with Logging{
  val log = Logger.getLogger(this.toString)
  val s = new Stack[Int](5)

  for (i <- 6 to 3 by -1 ) {
    s.push(i)
  }

  for (e <- s.popAll()){
    log.info(e.toString())
  }

  val q = new Queue[Int](6)
  for (i <- 0 to 5) {
    q.enQueue(i)
  }

  for (i <- 0 to 5) {
    println(q.deQueue())
  }

}
