   M S B A M L   `   `   `  ����F  BDeansOffice, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null1clr-namespace:DeansOffice.DALDeansOffice.DAL  5   	       DeansOffice.DAL.Window1   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   /localclr-namespace:DeansOffice.DAL     5   	     � Title$  Dodaj Studenta��5   	   $��351.473��6    $��308.801��61   .��5	      � $��0,0,0.2,-19.4q�6   .+�5
   
   �� -   5         ��Name$ button1��5
      $��Dodaj��6"   $
��Left=�62   $��109,286,0,0q�6M   $	��Top=�6b   $��75��6z   6�   �� 5   
   -   5        $ button2��5      $��Usuń��6"   $
��Left=�61   $��212,286,0,0q�6L   $	��Top=�6a   $��75��6y   6�   �� 5   
   -   5         ��Name$ label��5      $��Nazwisko��6   $
��Left=�62   $��	18,61,0,0q�6M   $	��Top=�6`   $��62��6x   $��23��6�   �� 5   
   -   5         ��Name$ textBoxNazwisko��5      $
��Left=�6+   $��23��6F   $��	92,61,0,0q�6R    �� TextWrapping$
 Wrap=�6e   $	��Top=�6y   $	��195��6�   �� 5   
   -   5        $ textBoxImie��5      $
��Left=�6'   $��23��6B   $��	92,89,0,0q�6N   $
 Wrap=�6a   $	��Top=�6u   $	��195��6�   �� 5   
   -   5        $ textBoxIndeks��5      $
��Left=�6)   $��23��6D   $��
92,117,0,0q�6P   $
 Wrap=�6d   $	��Top=�6x   $	��195��6�   �� 5   
   -   5         ��Name$ comboBoxStudia��5      $
��Left=�6R   $��
92,152,0,0q�6m   $	��Top=�6�   $	��195��6�   ��6+   �� *listOfStudies+6�   �� 5   
   -   5         ��Name$ listBoxPrzedmioty��5      $
��Left=�6W   $��84��6r   $��
92,189,0,0q�6~   $	��Top=�6�   $	��195��6�   ��6.   �� *listOfPrzedmioty+6�   �� 5   
   -	   5        $ 
label_Copy��5      $��
Przedmioty��6$   $
��Left=�69   $��
10,200,0,0q�6T   $	��Top=�6h   $��70��6�   $��30��6�   �� 5   
   -
   5        $ label_Copy1��5      $��Studia��6%   $
��Left=�66   $��
18,152,0,0q�6Q   $	��Top=�6e   $��62��6}   $��31��6�   �� 5   
   -   5        $ label_Copy2��5      $��
Nr indeksu��6%   $
��Left=�6:   $��	9,117,0,0q�6U   $	��Top=�6h   $��71��6�   $��23��6�   �� 5   
   -   5        $ label_Copy3��5      $��Imię��6%   $
��Left=�64   $��	35,89,0,0q�6O   $	��Top=�6b   $��45��6z   $��28��6�   �� 5   
   -   5        $ label_Copy4��5      $��Dodaj Studenta��6%   $
��Left=�6>   $��20(�6Y   $��10,10,0,275.4q�6g   $	��149��6~   5      5      