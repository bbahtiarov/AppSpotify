package com.example.appspotify.presentation.adapters

import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.recyclerview.widget.AsyncListDiffer
import com.example.appspotify.R
import kotlinx.android.synthetic.main.swipe_item.view.*

class SwipeSongAdapter : BaseSongAdapter(R.layout.swipe_item) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.itemView.apply {
            val builder = SpannableStringBuilder()
            val title = SpannableString(song.title)
            title.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorWhite)), 0, title.length, 0)

            val text = SpannableString(song.subtitle)
            text.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorWhite)), 0, text.length, 0)

            builder.append(title).append(" • ").append(text)

            tvPrimary.isSelected = true
            tvPrimary.text = builder

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }
}



















