   M S B A M L   `   `   `  ����F  BDeansOffice, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null)clr-namespace:DeansOfficeDeansOffice  5   	       DeansOffice.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   +localclr-namespace:DeansOffice     5   	     � Title$  
MainWindow��5   	   $��475.2��6   $��753.2��6+   .��5	      � .+�5   
   �� $��10,75,526.2,304.6q�6   $��28(�6+   $��Lista studentów��69   �� 5   
   $��18(�6   $��10,36,683.2,375.6q�6   $	��200��69   .��6F   Plik6L   &   System.Windows.Controls.DataGrid  5   
   -   5        $��StudentsDataGrid��5      $��2��6+   $��2��6?      AutoGenerateColumns .  $
��Left=�5      $	��239��6.   $��
10,130,0,0q�6;   $	��Top=�6O   $	��709��5         Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ Nazwisko��6%   1  +System.Windows.Controls.DataGridBoundColumn   Binding 67   �� *
Nazwisko+  5      $
 Imie��6%      Width5  /System.Windows.Controls.DataGridLengthConverter$ 90 63    6>   �� *Imie+  5      $ Numer Indeksu��6%   $	 140 6<    6H   �� *	NrIndeksu+  5      $ Adres��6%   $	 150 64    6@   �� *Adres+  5      $ Studia��6%   $	 260 65    6A   �� *Studia+5      �� 5   
   -   5        $��Dodaj��5      $��Dodaj��6   $
��Left=�6.   $��488,391,0, 0q�6I   $	��Top=�6_   $��82��6w   $��37��6�   �� 5   
   -   5        $
��Usun��5      $��Usuń��6   $
��Left=�6,   $��627,391,0,0q�6G   $	��Top=�5      $��82��6)   $��37��6G   �� 5   
   -   5        $��myLabel��5      $��75,397,642.2,17.6q�6=   ��6   �� *	IdCounter+6=   �� 5   
   $��
Wybrałeś��6   $
��Left=�6#   $��
10,397,0,0q�6>   $	��Top=�6R   $��31��6j   $��62��6v   �� 5    
   $��
Studentów��6   $
��Left=�6$   $��110,397,0,0q�6?   $	��Top=�6T   $��31��6l   $��71��6x   �� 5!   
   
���   �$��1q�6%   $
��Left=�69   $��39��6T   $	��Top=�6`   $	��747��6x   $��0,36,0,0q�6�   5"      5$      