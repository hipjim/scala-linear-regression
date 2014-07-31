package regression

class LinearRegression(x: Array[Double], y: Array[Double]) {

  private[this] val n: Int = x.length

  var sumx: Double = 0.0
  var sumy: Double = 0.0
  var sumx2: Double = 0.0

  for (i <- 0 to (n - 1)) {
    sumx += x(i)
    sumx2 += x(i) * x(i)
    sumy += y(i)
  }

  val xbar: Double = sumx / n
  val ybar: Double = sumy / n

  var xxbar: Double = 0.0
  var yybar: Double = 0.0
  var xybar: Double = 0.0

  for (i <- 0 to (n - 1)) {
    xxbar += (x(i) - xbar) * (x(i) - xbar)
    yybar += (y(i) - ybar) * (y(i) - ybar)
    xybar += (x(i) - xbar) * (y(i) - ybar)
  }

  val beta1: Double = xybar / xxbar
  val beta0: Double = ybar - beta1 * xbar

  def f(x: Double): Double = (beta1 * x) + beta0
}
