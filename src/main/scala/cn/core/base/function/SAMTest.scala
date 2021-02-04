package base.function
import javax.swing._
import java.awt.event
import java.awt.event.{ActionEvent, ActionListener}

object SAMTest {

  val button=new JButton("Click")
  button.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      println("Click Me!!")
    }
  })

  implicit def getActionListener(actionProcessFunc:(ActionEvent)=>Unit)=new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit ={
      actionProcessFunc
    }
  }

  button.addActionListener((event:ActionEvent)=>println("Click me"))




}
