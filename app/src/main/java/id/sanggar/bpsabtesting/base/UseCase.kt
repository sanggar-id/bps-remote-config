package id.sanggar.bpsabtesting.base

abstract class UseCase<P, T> {
    abstract fun execute(param: P): T
}