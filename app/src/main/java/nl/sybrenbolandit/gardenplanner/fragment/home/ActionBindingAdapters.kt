package nl.sybrenbolandit.gardenplanner.fragment.home

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import nl.sybrenbolandit.gardenplanner.R
import nl.sybrenbolandit.gardenplanner.domain.Action
import nl.sybrenbolandit.gardenplanner.domain.ActionType

@BindingAdapter("actionTitle")
fun TextView.setActionTitle(item: Action?) {
    item?.let { text = item.title }
}

@BindingAdapter("actionDescription")
fun TextView.setActionDescription(item: Action?) {
    item?.let { text = item.description }
}

@BindingAdapter("actionTypeImage")
fun ImageView.setActionTypeImage(item: Action?) {
    item?.let {
        setImageResource(when (item.type) {
            ActionType.ADDITION -> R.drawable.icon_shovel
            ActionType.MAINTENANCE -> R.drawable.icon_water_holder
            ActionType.ALERT -> R.drawable.icon_alert
        })
    }
}