package mappers

interface Mapper<I, T> {
    fun map(input: I): T
}
