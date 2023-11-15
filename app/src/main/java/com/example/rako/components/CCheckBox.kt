package com.example.rako.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CCheckBox(
    label: String,
    modifier: Modifier = Modifier,
    state: CCheckBoxState = CCheckBoxState()
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        content = {
            Checkbox(
                checked = state.isChecked,
                onCheckedChange = { state.isChecked = it },
                colors = CheckboxDefaults.colors(
                    checkmarkColor = Color(0xFFDC4534),
                    uncheckedColor = Color(0xFFA8A8A8), checkedColor = Color(0xFFA8A8A8)

                ),
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = label)
        }
    )

}