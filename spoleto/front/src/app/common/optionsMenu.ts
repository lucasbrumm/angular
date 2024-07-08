import { OptionsMenu } from '../model/optionsMenu';

// menu-options.ts
export const MENU_OPTIONS: OptionsMenu[] = [
  {
    label: 'Home',
    route: '/',
  },
  {
    label: 'Manage sales system',
    route: '/sales',
  },
  {
    label: 'Manage purchasing system',
    route: '/purchase',
  },
  {
    label: 'View Stock',
    route: '/stock',
  },
  {
    label: 'View reports',
    route: '/reports',
  },
];
