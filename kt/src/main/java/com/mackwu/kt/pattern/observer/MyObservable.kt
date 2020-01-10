package com.mackwu.kt.pattern.observer

/**
 * ===================================================
 * Created by MackWu on 2020/1/6 14:28
 * <a href="mailto:wumengjiao828@163.com">Contact me</a>
 * <a href="https://github.com/mackwu828">Follow me</a>
 * ===================================================
 * 被观察者
 */
interface MyObservable {
    /**
     * 注册观察者
     */
    fun registerObserver(observer: MyObserver)

    /**
     * 移除观察者
     */
    fun removeObserver(observer: MyObserver)

    /**
     * 通知观察者
     */
    fun notifyObservers(data: Any)
}