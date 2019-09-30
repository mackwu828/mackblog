package com.mackwu.fragment.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mackwu.fragment.R

/**
 * ===================================================
 * Created by MackWu on 2019/8/14 10:16
 * <a href="mailto:wumengjiao828@163.com">Contact me</a>
 * <a href="https://github.com/mackwu828">Follow me</a>
 * ===================================================
 * Fragment被创建时生命周期
 * 09-30 01:20:31.777 4020-4020/com.mackwu.fragment D/TAG: onAttach...
 * 09-30 01:20:31.777 4020-4020/com.mackwu.fragment D/TAG: onCreate...
 * 09-30 01:20:31.778 4020-4020/com.mackwu.fragment D/TAG: onCreateView...
 * 09-30 01:20:31.779 4020-4020/com.mackwu.fragment D/TAG: onActivityCreated...
 * 09-30 01:20:31.779 4020-4020/com.mackwu.fragment D/TAG: onStart...
 * 09-30 01:20:31.779 4020-4020/com.mackwu.fragment D/TAG: onResume...
 * 按返回键
 * 09-30 01:21:24.224 4020-4020/com.mackwu.fragment D/TAG: onPause...
 * 09-30 01:21:24.228 4020-4020/com.mackwu.fragment D/TAG: onStop...
 * 09-30 01:21:24.228 4020-4020/com.mackwu.fragment D/TAG: onDestroyView...
 * 09-30 01:21:24.229 4020-4020/com.mackwu.fragment D/TAG: onDestroy...
 * 09-30 01:21:24.229 4020-4020/com.mackwu.fragment D/TAG: onDetach...
 */
class HomeFragment : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d("HomeFragment", "onAttach...")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HomeFragment", "onCreate...")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("HomeFragment", "onCreateView...")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("HomeFragment", "onActivityCreated...")
    }

    override fun onStart() {
        super.onStart()
        Log.d("HomeFragment", "onStart...")
    }

    override fun onResume() {
        super.onResume()
        Log.d("HomeFragment", "onResume...")
    }

    override fun onPause() {
        super.onPause()
        Log.d("HomeFragment", "onPause...")
    }

    override fun onStop() {
        super.onStop()
        Log.d("HomeFragment", "onStop...")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("HomeFragment", "onDestroyView...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeFragment", "onDestroy...")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("HomeFragment", "onDetach...")
    }

}