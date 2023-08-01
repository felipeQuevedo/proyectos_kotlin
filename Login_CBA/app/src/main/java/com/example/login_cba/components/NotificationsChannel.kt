package com.example.login_cba.components

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.login_cba.MainActivity
import android.Manifest
import com.example.login_cba.R

fun CreateChannelNotification(
    idChannel: String,
    context: Context,
    name: String,
    descriptionText: String
) {
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

        val importance = NotificationManager.IMPORTANCE_HIGH
        //Definicion del Canal
        val channel = NotificationChannel(
            idChannel,
            name,
            importance
        ).apply {
            description = descriptionText
        }
        //Definicion del Gestor de Notificaciones
        val  notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //Creacion del canal
        notificationManager.createNotificationChannel(channel)
    }
}

fun notificacionSencilla(
    context: Context,
    idChannel: String,
    idNotification: Int,
    textTitle: String,
    textContext: String,
    priority: Int = NotificationCompat.PRIORITY_HIGH
){
    val intent = Intent(
        context,
        MainActivity::class.java
    ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        context,
        0,
        intent,
        PendingIntent.FLAG_IMMUTABLE
    )

    val builder = NotificationCompat.Builder(
        context,
        idChannel
    )
        .setSmallIcon(R.drawable.ic_shopping_cart_24)
        .setContentTitle(textTitle)
        .setContentText(textContext)
        .setPriority(priority)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()

    with(NotificationManagerCompat.from(context)){
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
        ) !=PackageManager.PERMISSION_GRANTED
        ){
            // TODO: Consider Calling
            //  ActivityCompat#requestPermissions
            // here to request the missing permisions, and the overriding
            // public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                        int[] grantResults)
            // yo handle the case where the user grantys the permission. See the documentation
            // for ActivityCompat#requestPermissions  for more details.
            return
        }
        notify(idNotification, builder)
    }
}

fun notificacionImagen(
    context: Context,
    idChannel: String,
    idNotification: Int,
    textTitle: String,
    textContext: String,
    bigIcono: Bitmap,
    bigImagen: Bitmap,
    priority: Int = NotificationCompat.PRIORITY_HIGH
){
    val intent = Intent(
        context,
        MainActivity::class.java
    ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        context,
        0,
        intent,
        PendingIntent.FLAG_IMMUTABLE
    )

    val builder = NotificationCompat.Builder(
        context,
        idChannel
    )
        .setSmallIcon(R.drawable.ic_shopping_cart_24)
        .setContentTitle(textTitle)
        .setContentText(textContext)
        .setLargeIcon(bigIcono)
        .setStyle(
            NotificationCompat
                .BigPictureStyle()
                    .bigPicture(bigImagen)
                .setBigContentTitle("Tienda Sena CBA")
        )
        .setPriority(priority)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()


    with(NotificationManagerCompat.from(context)){
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) !=PackageManager.PERMISSION_GRANTED
        ){
            // TODO: Consider Calling
            //  ActivityCompat#requestPermissions
            // here to request the missing permisions, and the overriding
            // public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                        int[] grantResults)
            // yo handle the case where the user grantys the permission. See the documentation
            // for ActivityCompat#requestPermissions  for more details.
            return
        }
        notify(idNotification, builder)
    }
}
