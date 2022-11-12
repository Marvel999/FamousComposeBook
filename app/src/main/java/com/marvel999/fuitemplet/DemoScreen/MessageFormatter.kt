package com.marvel999.fuitemplet.DemoScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight


//Now this message formatter will identify the #tag one
val symbolPattern by lazy {
    Regex("""(#\w+)""")
}

@Composable
fun messageFormatter(
    comment: String
): AnnotatedString {
    val tokens = symbolPattern.findAll(comment);
    var currentPosition = 0;
   return buildAnnotatedString {
        for (token in tokens) {
            append(comment.slice(currentPosition until token.range.first))

            val annotatedString = AnnotatedString(
                text = token.value,
                spanStyle = SpanStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold
                )
            )
            append(annotatedString)
            currentPosition = token.range.last + 1
        }
       if(!tokens.none()) {
           append(comment.slice(currentPosition..comment.lastIndex))
       } else {
          append(comment)
       }
    }
}



