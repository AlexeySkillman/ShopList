package com.example.shoplist.di.annotations

import javax.inject.Scope

// То же самое что Singleton (Класс будет жить ровно столько сколько живет компонент)
// Чтобы не запутаться в Singleton создают свои Анотации, и по названию анотации мы понимаем сколько живет этот класс или зависимость

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope