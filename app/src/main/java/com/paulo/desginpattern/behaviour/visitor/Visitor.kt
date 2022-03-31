package com.paulo.desginpattern.behaviour.visitor
/*
    Separation between an algorithm and the objects they operate on
    2 concepts: visitor and element ( visitable )
        The element accepts visitor type objects
*/
interface ReportElement{
    fun<R> accept(visitor: ReportVisitor<R>): R
}

class FixedPriceContract(val costPerYear: Long): ReportElement{
    override fun <R> accept(visitor: ReportVisitor<R>): R {
        return visitor.visit(this)
    }
}
class TimeAndMaterialsContract(val costPerHour: Long, val hours: Long): ReportElement{
    override fun <R> accept(visitor: ReportVisitor<R>): R {
        return visitor.visit(this)
    }
}
class SupportContract(val costPerMonth: Long): ReportElement{
    override fun <R> accept(visitor: ReportVisitor<R>): R {
        return visitor.visit(this)
    }
}
interface ReportVisitor<out R>{
    fun visit(contract: FixedPriceContract): R
    fun visit(contract: TimeAndMaterialsContract): R
    fun visit(contract: SupportContract): R
}
class MonthlyCostReportVisitor: ReportVisitor<Long>{
    override fun visit(contract: FixedPriceContract): Long {
        return contract.costPerYear / 12
    }

    override fun visit(contract: TimeAndMaterialsContract): Long {
        return contract.costPerHour * contract.hours
    }

    override fun visit(contract: SupportContract): Long {
        return contract.costPerMonth
    }
}

class YearlyVisitor: ReportVisitor<Long>{
    override fun visit(contract: FixedPriceContract): Long {
        return contract.costPerYear
    }

    override fun visit(contract: TimeAndMaterialsContract): Long {
        return contract.costPerHour * contract.hours
    }

    override fun visit(contract: SupportContract): Long {
        return  contract.costPerMonth * 12
    }

}


fun main() {
    val projectAlpha = FixedPriceContract(10_000)
    val projectBeta = SupportContract(500_000)
    val projectGamm = TimeAndMaterialsContract(1000, 10)
    val projectKappa = TimeAndMaterialsContract(100, 10)

    val projects = arrayListOf(
        projectAlpha,
        projectBeta,
        projectGamm,
        projectKappa
    )

    val monthlyCostVisitor = MonthlyCostReportVisitor()
    val monthlyCost = projects.map { it.accept(monthlyCostVisitor) }.sum()
    println("Monthly cost: $monthlyCost")
}










