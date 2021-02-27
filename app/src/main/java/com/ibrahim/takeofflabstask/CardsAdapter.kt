package com.ibrahim.takeofflabstask

import android.app.Activity
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ibrahim.takeofflabstask.feature.data.model.Profile
import com.squareup.picasso.Picasso


class CardsAdapter(activity: Activity, data: List<Profile>) :
    BaseAdapter() {
    private val activity: Activity
    private var data: List<Profile>
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Profile {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView: View? = convertView
        val holder: ViewHolder
        val inflater =
            activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(com.ibrahim.takeofflabstask.R.layout.profile_item, parent, false)
            // get all UI view
            holder = ViewHolder(convertView!!)
            // set tag for holder
            convertView!!.tag = holder
        } else {
            // if holder created, get tag from view
            holder = convertView.getTag() as ViewHolder
        }

        //setting data to views
        holder.bind(data[position])

        return convertView
    }

    fun updateProfiles(it: List<Profile>) {
        data = it
        notifyDataSetChanged()
    }

    private inner class ViewHolder(view: View) {
        fun bind(profile: Profile) {
            Picasso.get()
                .load(profile.photos[0])
                .fit().centerCrop()
                .into(avatar)

            name.text = "${ profile.first_name}, ${ profile.last_name}"
            location.text = "${ profile.country}, ${ profile.city}"

        }
        val avatar: ImageView
        val name: TextView
        val location: TextView

        init {
            avatar = view.findViewById(com.ibrahim.takeofflabstask.R.id.avatar) as ImageView
            name = view.findViewById(com.ibrahim.takeofflabstask.R.id.tvName)
            location = view.findViewById(com.ibrahim.takeofflabstask.R.id.tvCity)
        }
    }

    companion object {
        private const val AVATAR_WIDTH = 150
        private const val AVATAR_HEIGHT = 300
        fun decodeSampledBitmapFromResource(
            res: Resources?,
            resId: Int,
            reqWidth: Int,
            reqHeight: Int
        ): Bitmap {

            // First decode with inJustDecodeBounds=true to check dimensions
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeResource(res, resId, options)

            // Calculate inSampleSize
            options.inSampleSize =
                calculateInSampleSize(options, reqWidth, reqHeight)

            // Decode bitmap with inSampleSize set
            options.inJustDecodeBounds = false
            return BitmapFactory.decodeResource(res, resId, options)
        }

        fun calculateInSampleSize(
            options: BitmapFactory.Options,
            reqWidth: Int,
            reqHeight: Int
        ): Int {
            // Raw height and width of image
            val height = options.outHeight
            val width = options.outWidth
            var inSampleSize = 1
            if (height > reqHeight || width > reqWidth) {
                val halfHeight = height / 2
                val halfWidth = width / 2

                // Calculate the largest inSampleSize value that is a power of 2 and keeps both
                // height and width larger than the requested height and width.
                while (halfHeight / inSampleSize >= reqHeight
                    && halfWidth / inSampleSize >= reqWidth
                ) {
                    inSampleSize *= 2
                }
            }
            return inSampleSize
        }
    }

    init {
        this.data = data
        this.activity = activity
    }
}