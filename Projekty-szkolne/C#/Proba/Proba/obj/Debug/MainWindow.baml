   M S B A M L   `   `   `  ����@  <Proba, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullclr-namespace:ProbaProba  5   	       Proba.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   %localclr-namespace:Proba     5   	     � Title$  
MainWindow��5   	   $	��510��6   $��725.6��6)   .��5	      � $
��Left=�6   $	��694��6&   $��	0,0,0,-54q�62   $	��474��6E   $	��Top=�6R   .+�5
   
   �� -   5         ��Name$ label��5
      $��Szukaj��6   $
��Left=�60   $��	42,51,0,0q�6K   $	��Top=�6^   �� 5   
   -   5         ��Name$ textBox_Szukaj��5      $
��Left=�6*   $��22��6E   $��
106,55,0,0q�6Q    �� TextWrapping$
 Wrap=�6e   $	��Top=�6y   $	��191��6�   �� 5   
   -   5         ��Name$ Szukaj��5      $��Szukaj��6!   $
��Left=�62   $��
333,55,0,0q�6M   $	��Top=�6a   $	��105��6y   $��23��6�   �� 5   
   -   5        $ Pokaz��5      $��Pokaż Wszystkich��6    $
��Left=�6;   $��
475,55,0,0q�6V   $	��Top=�6j   $	��150��6�   $��23��6�   &   System.Windows.Controls.DataGrid  5   
   -   5          Name$ EmployeeGrid��5         AutoGenerateColumns .  $
��Left=�6E   $	��164��6`   $��
10,123,0,0q�6m   $	��Top=�6�   $	��670��6�      CanUserAddRows .     Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn	   MinWidth$		 180Q�6&   
   Header$
 Employee��65      MaxWidth$	 290Q�6G   1  +System.Windows.Controls.DataGridBoundColumn   Binding 6V   �� *Ename+ �� Mode$ TwoWay=�  5      $		 270Q�6&   $	
 Job��65   $	 290Q�6B    6Q   �� *Job+$ TwoWay=�  5      $		 230Q�6&   $
 Dname��65   $	 290Q�6D    6S   �� *Dname+$ TwoWay=�5      �� 5   
   -   5        $ DodajPracownika��5      $��DodajPracownika��6)   $
��Left=�6C   $��
10,292,0,0q�6^   $	��Top=�6r   �� 5   
   -   5        $ Ename��5      $��Ename��6   $
��Left=�6/   $��
10,332,0,0q�6J   $	��Top=�6^   �� 5   
   -   5        $	 Job��5      $	��Job��6   $
��Left=�6+   $��
10,363,0,0q�6F   $	��Top=�6Z   �� 5   
   -	   5        $ Dname��5      $��Dname��6   $
��Left=�6/   $��
10,394,0,0q�6J   $	��Top=�6^   �� 5   
   -
   5        $ textBox_Ename��5      $
��Left=�6)   $��23��6D   $��
69,335,0,0q�6P   $
 Wrap=�6d   $	��Top=�6x   $	��175��6�   �� 5   
   -   5        $ textBox_job��5      $
��Left=�6'   $��23��6B   $��
69,367,0,0q�6N   $
 Wrap=�6b   $	��Top=�6v   $	��175��6�   �� 5   
   -   5         ��Name$ comboBox_Dname��5       �� 
IsReadOnly . $
��Left=�6^   $��
69,396,0,0q�6y   $	��Top=�6�   $	��175��6�   ��6=   �� *
DnameBox+6�   �� 5   
   -   5        $ Dodaj��5      $��Dodaj��6    $
��Left=�60   $��106,432,0,0q�6K   $	��Top=�6`   $	��138��6x   $��27��6�   6�   5       5!      