package com.remydupont.notescleanarchitecture.ui.feature_counters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.remydupont.notescleanarchitecture.domain.model.Counter
import com.remydupont.notescleanarchitecture.ui.theme.RedOrange

@Composable
fun CounterItem(counter: Counter) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(
                color = RedOrange,
                shape = RoundedCornerShape(50)
            )
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.Remove, contentDescription = "Decrease", modifier = iconModifier)
        VerticalDivider(Modifier.padding(4.dp))
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = counter.name)
            Text(text = counter.value.toString())
        }
        VerticalDivider(Modifier.padding(4.dp))
        Icon(imageVector = Icons.Default.Add, contentDescription = "Increase", modifier = iconModifier)
    }
}

@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onSurface.copy(alpha = DividerAlpha),
    thickness: Dp = 1.dp
) {
    Box(
        modifier
            .fillMaxHeight()
            .width(thickness)
            .background(color = color)
    )
}

private const val DividerAlpha = 0.12f
private val iconModifier = Modifier.size(24.dp)
