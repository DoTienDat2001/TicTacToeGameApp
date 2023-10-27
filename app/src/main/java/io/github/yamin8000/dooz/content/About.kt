package io.github.yamin8000.dooz.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import io.github.yamin8000.dooz.BuildConfig
import io.github.yamin8000.dooz.R
import io.github.yamin8000.dooz.ui.composables.PersianText
import io.github.yamin8000.dooz.ui.composables.Ripple
import io.github.yamin8000.dooz.ui.composables.ScaffoldWithTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AboutContent(onBackClick: () -> Unit) {
    ScaffoldWithTitle(
        title = stringResource(R.string.about),
        onBackClick = onBackClick,
        content = {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    val uriHandler = LocalUriHandler.current
                    val sourceUri = stringResource(R.string.github_source)
                    val licenseUri = stringResource(R.string.license_link)
                    val developerUri = stringResource(R.string.developer_uri)
                    Ripple(
                        onClick = { uriHandler.openUri(licenseUri) },
                        content = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_gplv3),
                                contentDescription = stringResource(id = R.string.gplv3_image_description),
                                modifier = Modifier
                                    .padding(32.dp)
                                    .fillMaxWidth(),
                                contentScale = ContentScale.FillWidth,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
                            )
                        }
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(
                            8.dp,
                            Alignment.CenterHorizontally
                        )
                    ) {
                        val version = stringResource(R.string.version_name)
                        PersianText("$version - ${BuildConfig.FLAVOR}")
                        PersianText(BuildConfig.VERSION_NAME)
                    }
                    PersianText(
                        text = stringResource(R.string.license_header),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Ripple(
                        onClick = { uriHandler.openUri(sourceUri) },
                        content = {
                            Text(
                                text = sourceUri,
                                textDecoration = TextDecoration.Underline
                            )
                        }
                    )
                    Ripple(
                        onClick = { uriHandler.openUri(developerUri) },
                        content = {
                            Text(
                                text = developerUri,
                                textDecoration = TextDecoration.Underline
                            )
                        }
                    )
                }
            }
        }
    )
}