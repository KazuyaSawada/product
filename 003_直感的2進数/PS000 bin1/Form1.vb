Public Class Form1

    Dim dec As Integer

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load

        viewClearMethod()
        Label2.BackColor = Color.FromArgb(&HF0, &HF0, &HF0)

    End Sub

    Private Sub viewClearMethod()

        binClearMethod()
        decClearMethod()

    End Sub

    Private Sub CheckBoxBit_CheckedChanged(sender As Object, e As EventArgs) Handles CheckBox2.CheckedChanged, CheckBox3.CheckedChanged, CheckBox4.CheckedChanged, CheckBox5.CheckedChanged, CheckBox6.CheckedChanged, CheckBox7.CheckedChanged, CheckBox8.CheckedChanged, CheckBox9.CheckedChanged

        updateMethod()

    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click

        allClearMethod()

    End Sub

    Private Sub CheckBox1_CheckedChanged(sender As Object, e As EventArgs) Handles CheckBox1.CheckedChanged

        If (CheckBox1.Checked = True) Then
            Label2.BackColor = Color.Black
            CheckBox1.Text = "現"
        ElseIf (CheckBox1.Checked = False) Then
            Label2.BackColor = Color.FromArgb(&HF0, &HF0, &HF0)
            CheckBox1.Text = "隠"
        End If

    End Sub

    Private Sub allClearMethod()

        checkClearMethod()
        binClearMethod()
        decClearMethod()

    End Sub

    Private Sub checkClearMethod()

        CheckBox2.Checked = False
        CheckBox3.Checked = False
        CheckBox4.Checked = False
        CheckBox5.Checked = False
        CheckBox6.Checked = False
        CheckBox7.Checked = False
        CheckBox8.Checked = False
        CheckBox9.Checked = False

        CheckBox1.Checked = False

    End Sub

    Private Sub binClearMethod()

        Label11.Text = "0"
        Label12.Text = "0"
        Label13.Text = "0"
        Label14.Text = "0"
        Label15.Text = "0"
        Label16.Text = "0"
        Label17.Text = "0"
        Label18.Text = "0"

    End Sub

    Private Sub decClearMethod()

        dec = 0
        Label2.Text = dec

    End Sub

    Private Sub updateMethod()

        viewClearMethod()

        If (CheckBox2.Checked = True) Then
            dec = dec + 1
            Label11.Text = "1"
        End If
        If (CheckBox3.Checked = True) Then
            dec = dec + 2
            Label12.Text = "1"
        End If
        If (CheckBox4.Checked = True) Then
            dec = dec + 4
            Label13.Text = "1"
        End If
        If (CheckBox5.Checked = True) Then
            dec = dec + 8
            Label14.Text = "1"
        End If
        If (CheckBox6.Checked = True) Then
            dec = dec + 16
            Label15.Text = "1"
        End If
        If (CheckBox7.Checked = True) Then
            dec = dec + 32
            Label16.Text = "1"
        End If
        If (CheckBox8.Checked = True) Then
            dec = dec + 64
            Label17.Text = "1"
        End If
        If (CheckBox9.Checked = True) Then
            dec = dec + 128
            Label18.Text = "1"
        End If

        Label2.Text = dec

    End Sub

End Class
