package dependencies

object Deps {
    object Gradle {
        const val gradle = "com.android.tools.build:gradle:4.0.1"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
        const val hiltAndroidGradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
    }

    object Kotlin {
        const val version = "1.3.72"
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"

        object Hilt {
            private const val version = "1.0.0-alpha01"
            const val lifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
            const val compiler = "androidx.hilt:hilt-compiler:$version"
        }
    }

    object Retrofit {
        private const val version = "2.7.1"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object Hilt {
        private const val version = "2.28-alpha"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
    }
}