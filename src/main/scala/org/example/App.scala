package org.example
import scala.io.StdIn.readLine
/**
 * @author ${user.name}
 */
object App {
  
//  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
    var x = "Hello, Scala!"
    println(x)
    // выводит фразу «Hello, Scala!» справа налево
    println(x.reverse)
    // переводит всю фразу в нижний регистр
    println(x.toLowerCase)
    // удаляет символ! init - все кроме последнего
    println(x.init)
    println(x.replace("!", ""))
    // добавляет в конец фразы
    println(x.replace("!", "") + " and goodbye python!")

    // доп.
    //    println("concat arguments = " + foo(args))
    //    println("Введите годовой доход:")
    //    val yearSalary = readLine().toInt
    //    println("Введите премию:")
    //    val bonus = readLine().toFloat
    //    println("Введите компенсацию питания:")
    //    val eatBonus = readLine().toInt

  }

  // Напишите программу, которая вычисляет ежемесячный оклад сотрудника после вычета налогов.
  // На вход вашей программе подается значение годового дохода до вычета налогов,
  // размер премии – в процентах от годового дохода и компенсация питания.
  def get_salary(income: Double, premium: Double, compensation: Double): Unit = {
    val salary = ((income - (income * premium / 100) - compensation) / 12) * 0.87
    println("Оклад " + salary.toString)

    println("------------------------")
  }
  get_salary(1000000.00, 35.0, 1500.0)

  // Напишите программу, которая рассчитывает для каждого сотрудника отклонение(в процентах)
  // от среднего значения оклада на уровень всего отдела.
  // В итоговом значении должно учитываться в большую или меньшую сторону отклоняется размер оклада.
  // На вход вышей программе подаются все значения, аналогичные предыдущей программе,
  // а также список со значениями окладов сотрудников отдела 100, 150, 200, 80, 120, 75.
  def dev_salary(income: Double, premium: Double, compensation: Double, salaries: List[Double]): Unit = {
    val salary = ((income - (income * premium / 100) - compensation) / 12) * 0.87
    var mean = salaries.sum / salaries.size
    println("Среднее значение оклада " + mean.round)
    val dev = salary * 100 / mean
    if (dev > 100) {
      println("Отклонение в большую сторону на  " + (dev - 100).round + "%")
    } else {
      println("Отклонение в меньшую сторону на  " + dev.round + "%")
    }
    println("------------------------")
  }
  dev_salary(1000000.00, 35.0, 1500.0, List(100000.0, 150000.0, 200000.0, 80000.0, 120000.0, 75000.0))

  //  Попробуйте рассчитать новую зарплату сотрудника, добавив(или отняв, если сотрудник плохо себя вел)
  //  необходимую сумму с учетом результатов прошлого задания.
  //  Добавьте его зарплату в список и вычислите значение самой высокой зарплаты и самой низкой.
    def min_max_salary(income: Double, premium: Double, pr: Double, compensation: Double, salaries: List[Double]): Unit = {
      val salary = ((income - (income * premium / 100) - compensation) / 12) * 0.87
      val new_salary = (salary + pr)
      val new_list = salaries :+ new_salary

      println("ЗП " + new_salary)
      val max = new_list.max
      val min = new_list.min
      println("Самая высокая ЗП " + max)
      println("Самая низкая ЗП " + min)
      println("------------------------")

    }

    min_max_salary(1000000, 35, 1500, -3000,
      List(100000.0, 150000.0, 200000.0, 80000.0, 120000.0, 75000.0))

  // Также в вашу команду пришли два специалиста с окладами 350 и 90 тысяч рублей.
  // Попробуйте отсортировать список сотрудников по уровню оклада от меньшего к большему.
  def new_salaries(salary1: Double, salary2: Double, salaries: List[Double]): Unit = {
    val new_salaries = salaries :+ salary1 :+ salary2
    val new_sorted = new_salaries.sorted

    println("Cписок сотрудников по уровню оклада от меньшего к большему:")
    new_sorted.foreach(println)
    println("------------------------")
  }

  new_salaries(
    350.0, 90.0, List(100.0, 150.0, 200.0, 80.0, 120.0, 75.0))

  //  Кажется, вы взяли в вашу команду еще одного сотрудника и предложили ему оклад 130 тысяч.
  //  Вычислите самостоятельно номер сотрудника в списке так, чтобы сортировка не нарушилась и добавьте его на это место.
  def new_employee(salary: Double, salaries: List[Double]): Unit = {
    val new_sorted = salaries.sorted
    val new_index = new_sorted.indexWhere(e => e >= salary)
    println("Сотрудника необходимо добавить к :" + new_index)
    var new_list: List[Double] = List()
    for (i<-new_sorted.indices) {
      if (i == new_index) {
        new_list = new_list :+ salary
      }
      new_list :+= new_sorted(i)
    }
    new_sorted.foreach(println)
    println("------------------------")
  }

  new_employee(
    130.0, List(100.0, 150.0, 200.0, 80.0, 120.0, 75.0))

  // Попробуйте вывести номера сотрудников из полученного списка, которые попадают под категорию middle.
  // На входе программе подается «вилка» зарплаты специалистов уровня middle.
  def folk(salaries: List[Double]): Unit = {
    println("Вывести номера сотрудников из полученного списка, которые попадают под категорию middle:")
    for(i<-0 to salaries.size - 1) {
      if ((salaries(i) >= 120) && (salaries(i) <= 200)) {
        println("middle -> " + i + "(" + salaries(i) + ")")
      }
    }
    println("------------------------")
  }

  folk(List(100.0, 150.0, 200.0, 80.0, 120.0, 75.0))

//  Однако наступил кризис и ваши сотрудники требуют повысить зарплату.
  //  Вам необходимо проиндексировать зарплату каждого сотрудника на уровень инфляции – 7%
  def index_salary(salaries: List[Double]): Unit = {
    println("Проиндексировать зарплату каждого сотрудника на уровень инфляции – 7%:")
    var new_list: List[Double] = List()
    for (n <- salaries) {
      new_list :+= (n * 1.07)
    }
    new_list.foreach(println)
    println("------------------------")
  }

  index_salary(List(100.0, 150.0, 200.0, 80.0, 120.0, 75.0))
}
