package com.fawwaz.motor.ui.news

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.fawwaz.motor.R
import com.fawwaz.motor.data.model.News
import com.fawwaz.motor.databinding.ItemNewsBinding
import com.fawwaz.motor.ui.base.BaseAdapter

class NewsAdapter(val context: Context): BaseAdapter<News>(R.layout.item_news) {
    override fun onBind(binding: ViewDataBinding?, data: News) {
        val mBinding = binding as ItemNewsBinding
        Glide.with(context).load(data.gambar).into(mBinding.itemGambar)
    }

    override fun onClick(binding: ViewDataBinding?, data: News) {
        val intent = Intent(context, NewsActivity::class.java)
        intent.putExtra(NewsActivity.OPEN_MOTOR, data)
        context.startActivity(intent)
    }
}