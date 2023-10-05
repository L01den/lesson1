namespace ClinicDesctop
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            listViewClients = new ListView();
            columnHeaderId = new ColumnHeader();
            columnHeaderSurName = new ColumnHeader();
            columnHeaderFirstName = new ColumnHeader();
            columnHeaderPatronymic = new ColumnHeader();
            btnUpdate = new Button();
            button1 = new Button();
            lastName = new TextBox();
            firstName = new TextBox();
            patronymic = new TextBox();
            add = new Button();
            SuspendLayout();
            // 
            // listViewClients
            // 
            listViewClients.Columns.AddRange(new ColumnHeader[] { columnHeaderId, columnHeaderSurName, columnHeaderFirstName, columnHeaderPatronymic });
            listViewClients.FullRowSelect = true;
            listViewClients.GridLines = true;
            listViewClients.Location = new Point(12, 12);
            listViewClients.MultiSelect = false;
            listViewClients.Name = "listViewClients";
            listViewClients.Size = new Size(776, 173);
            listViewClients.TabIndex = 1;
            listViewClients.UseCompatibleStateImageBehavior = false;
            listViewClients.View = View.Details;
            // 
            // columnHeaderId
            // 
            columnHeaderId.Text = "#";
            // 
            // columnHeaderSurName
            // 
            columnHeaderSurName.Text = "Фамилия";
            columnHeaderSurName.Width = 200;
            // 
            // columnHeaderFirstName
            // 
            columnHeaderFirstName.Text = "Имя";
            columnHeaderFirstName.Width = 200;
            // 
            // columnHeaderPatronymic
            // 
            columnHeaderPatronymic.Text = "Отчество";
            columnHeaderPatronymic.Width = 200;
            // 
            // btnUpdate
            // 
            btnUpdate.Location = new Point(668, 191);
            btnUpdate.Name = "btnUpdate";
            btnUpdate.Size = new Size(120, 52);
            btnUpdate.TabIndex = 2;
            btnUpdate.Text = "Обновить";
            btnUpdate.UseVisualStyleBackColor = true;
            btnUpdate.Click += btnUpdate_Click;
            // 
            // button1
            // 
            button1.Location = new Point(276, 0);
            button1.Name = "button1";
            button1.Size = new Size(70, 8);
            button1.TabIndex = 3;
            button1.Text = "button1";
            button1.UseVisualStyleBackColor = true;
            // 
            // lastName
            // 
            lastName.Location = new Point(12, 322);
            lastName.Name = "lastName";
            lastName.Size = new Size(186, 23);
            lastName.TabIndex = 4;
            lastName.Text = "Имя";
            lastName.TextChanged += lastName_TextChanged;
            // 
            // firstName
            // 
            firstName.Location = new Point(220, 322);
            firstName.Name = "firstName";
            firstName.Size = new Size(186, 23);
            firstName.TabIndex = 5;
            firstName.Text = "Фамилия";
            firstName.TextChanged += firstName_TextChanged;
            // 
            // patronymic
            // 
            patronymic.Location = new Point(425, 322);
            patronymic.Name = "patronymic";
            patronymic.Size = new Size(186, 23);
            patronymic.TabIndex = 6;
            patronymic.Text = "Отчество";
            patronymic.TextChanged += textBox2_TextChanged;
            // 
            // add
            // 
            add.Location = new Point(668, 306);
            add.Name = "add";
            add.Size = new Size(120, 52);
            add.TabIndex = 7;
            add.Text = "Добавть";
            add.UseVisualStyleBackColor = true;
            add.Click += add_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(add);
            Controls.Add(patronymic);
            Controls.Add(firstName);
            Controls.Add(lastName);
            Controls.Add(button1);
            Controls.Add(listViewClients);
            Controls.Add(btnUpdate);
            Name = "Form1";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Моя клиника";
            Load += Form1_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ListView listViewClients;
        private Button btnUpdate;
        private ColumnHeader columnHeaderId;
        private ColumnHeader columnHeaderSurName;
        private ColumnHeader columnHeaderFirstName;
        private ColumnHeader columnHeaderPatronymic;
        private Button button1;
        private TextBox lastName;
        private TextBox firstName;
        private TextBox patronymic;
        private Button add;
    }
}