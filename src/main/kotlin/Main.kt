import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage
import java.util.Properties

fun sendEmail() {
    val username = "<Email>" // Your email address
    val password = "<Password>" // Your email password
    val to = "esaxena9927@gmail.com" // Recipient's email address

    val props = Properties()
    props["mail.smtp.auth"] = "true"
    props["mail.smtp.starttls.enable"] = "true"
    props["mail.smtp.host"] = "smtp.gmail.com" // SMTP server for Gmail
    props["mail.smtp.port"] = "587" // Port for Gmail

    val session = Session.getInstance(props, object : Authenticator() {
        override fun getPasswordAuthentication(): PasswordAuthentication {
            return PasswordAuthentication(username, password)
        }
    })

    try {
        val message = MimeMessage(session)
        message.setFrom(InternetAddress(username))
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to))
        message.subject = "Subject of your email"
        message.setText("This is the content of your email.")

        Transport.send(message)
        println("Email sent successfully.")
    } catch (e: MessagingException) {
        e.printStackTrace()
    }
}

fun main() {
    sendEmail()
}
