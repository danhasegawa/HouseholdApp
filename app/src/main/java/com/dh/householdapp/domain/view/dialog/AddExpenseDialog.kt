package com.dh.householdapp.domain.view.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dh.householdapp.domain.view.expense.ExpenseEvent
import com.dh.householdapp.domain.view.expense.ExpenseState
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpenseDialog(
    state: ExpenseState,
    onEvent: (ExpenseEvent) -> Unit,
    modifier: Modifier = Modifier
) {

     val dateDialogState = rememberMaterialDialogState()

    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onEvent(ExpenseEvent.HideDialog)
        },
        title = { Text(text = "Add Expense") },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Button(onClick = {
                    dateDialogState.show()
                }) {
                    Text(text = "Date")
                }
                Text(text = state.date)

                MaterialDialog(
                    dialogState = dateDialogState,
                    buttons = {
                        positiveButton(text = "Ok")
                        negativeButton(text = "Cancel")
                    }
                ) {
                    datepicker(
                        initialDate = LocalDate.now(),
                        title = "Pick a date",
                        onDateChange = {
                            onEvent(ExpenseEvent.SetDate(it))
                        }
                    )

                }

                TextField(
                    value = state.description,
                    onValueChange = {
                        onEvent(ExpenseEvent.SetDescription(it))
                    },
                    placeholder = {
                        Text(text = "Description")
                    }
                )
                TextField(
                    value = state.value,
                    onValueChange = {
                        onEvent(ExpenseEvent.SetValue(it))
                    },
                    placeholder = {
                        Text(text = "Value")
                    }
                )
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button(onClick = {
                    onEvent(ExpenseEvent.SaveExpense)
                }) {
                    Text(text = "Save")

                }

            }
        }
    )
}

