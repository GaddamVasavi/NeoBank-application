import React from 'react'; import { render, screen } from '@testing-library/react'; import { describe, it, expect } from 'vitest'; import { MemoryRouter } from 'react-router-dom'; import { DashboardPage } from '../pages/dashboard/DashboardPage';
describe('DashboardPage', () => {
  it('renders dashboard overview title', () => {
    render(<MemoryRouter><DashboardPage /></MemoryRouter>);
    expect(screen.getByText('Financial Overview')).toBeDefined();
  });
});
